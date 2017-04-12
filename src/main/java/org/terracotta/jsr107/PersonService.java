package org.terracotta.jsr107;

import java.util.Date;
import javax.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author GGIB
 */

@Component
public class PersonService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @CacheResult(cacheName = "people")
    public Person getPerson(int ssn)
    {
        LOGGER.info("ssn " + ssn + " not found in cache. TimeStamp: {}", new Date());

        switch (ssn)
        {
            case 123456789:
                return new Person(ssn, "Geoff", "Gibson");
            case 987654321:
                return new Person(ssn, "Cory", "Beck");
            default:
                return new Person(ssn,"John","Doe");
        }
    }


}
