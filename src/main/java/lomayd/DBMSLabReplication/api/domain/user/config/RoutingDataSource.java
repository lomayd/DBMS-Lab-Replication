package lomayd.DBMSLabReplication.api.domain.user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

        if(isReadOnly){
            log.info("Slave DB Selected");
        }
        else{
            log.info("Master DB Selected");
        }

        return isReadOnly ? "slave" : "master";
    }
}