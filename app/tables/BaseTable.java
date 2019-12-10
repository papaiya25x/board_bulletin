package tables;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.UpdatedTimestamp;

@MappedSuperclass
public abstract class BaseTable extends Model {

    @CreatedTimestamp
    public Date createdAt;

    @Version
    @UpdatedTimestamp
    public Date updatedAt;

}