package lt.asprogramuoju.refactoringkata.repository;

import lt.asprogramuoju.refactoringkata.domain.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    Item findById(ObjectId id);

    Item findByName(String name);

    @Query("{sellIn: ?0}")
    Item[] findBySellIn(int value);

    @Query("{quality: {$gte: ?0}}")
    Item[] findGoodQualityWhereQualityMoreThan(int value);
}
