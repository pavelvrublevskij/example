package lt.asprogramuoju.example.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class BookRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/book").get().outType(Book.class)
                .to("direct:talk");
        from("direct:talk")
                .process(exchange -> {
                    Book book = new Book();
                    book.getItem();
                    book.getDescription();
                    exchange.getIn().setBody(book);
                });
    }
}
