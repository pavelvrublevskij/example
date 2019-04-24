/***
 * - All items have a SellIn value which denotes the
 *   number of days we have to sell the item
 *
 * - All items have a Quality value which denotes
 *   how valuable the item is
 *
 * - At the end of each day our system lowers
 *   both values for every item
 */
package lt.asprogramuoju.refactoringkata.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "item")
public class Item {

    @Id
    private ObjectId id;

    private String name;

    //denotes the number of days to sell the item
    private int sellIn;
    private int quality;

    public String getId() {
        return id.toHexString();
    }
    public void setId(ObjectId id) {
        this.id = id;
    }

    /** denotes how valuable the item is
     * quality degrades twice when day has passed
     * The Quality of an item is never negative
     **/
    public void setQuality(int quality){
        if (quality < 0)
            this.quality = 0;
        else if (quality > 50)
            this.quality = 50;
        else
            this.quality = quality;
    }


    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
