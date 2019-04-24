# Refactoring kata

Hi and welcome to "Crazy fingers" team. We sell only the finest goods, but unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us. 

First an introduction to our system:

* All items have a SellIn value which denotes the number of days we have to sell the item
* All items have a Quality value which denotes how valuable the item is
* At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

* Once the sell by date has passed, Quality degrades twice as fast
* The Quality of an item is never negative
* "FM-Pro4" actually increases in Quality the older it gets
* The Quality of an item is never more than 50
* "Fuel level sensor", being a legendary item, never has to be sold or decreases in Quality
* "FM-Tco4 LCV" increases in Quality as it's SellIn value approaches: Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the sell by date has passed

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly
