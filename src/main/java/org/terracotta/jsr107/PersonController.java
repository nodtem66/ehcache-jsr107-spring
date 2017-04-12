package org.terracotta.jsr107;

import javax.cache.Cache;
import javax.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author GGIB
 */
@Controller
public class PersonController
{
    @Autowired PersonService personService;
    @Autowired CacheManager cacheManager;

    /**
     * Original demo function from Geoff Gibson
     * see: http://www.ehcache.org/blog/2016/05/18/ehcache3_jsr107_spring.html
     * @param ssn
     * @return 
     */
    @RequestMapping("/person/{ssn}")
    public @ResponseBody String getPerson(@PathVariable("ssn") int ssn)
    {
        return personService.getPerson(ssn).toString();
    }
    
    /**
     * get cache names from cacheManager bean
     * @return 
     */
    @RequestMapping("/caches")
    public @ResponseBody String printCacheNames()
    {
      StringBuilder builder = new StringBuilder();
      for (String name: cacheManager.getCacheNames())
      {
        builder.append(name);
        builder.append(" ");
      }
      return builder.toString();
    }
    
    /**
     * show Person from cache manually
     * @param ssn 
     * @return String
     */
    @RequestMapping("/cache/{ssn}")
    public @ResponseBody String getCachePerson(@PathVariable("ssn") int ssn) 
    {
      Cache<Integer, Person> cache = cacheManager.getCache("people");
      if (cache.containsKey(ssn))
      {
        return cache.get(ssn).toString();
      }
      return "(empty)";
    }
}
