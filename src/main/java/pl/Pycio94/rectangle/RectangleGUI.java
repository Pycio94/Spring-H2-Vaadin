package pl.Pycio94.rectangle;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleGUI extends VerticalLayout {

    private RectangleRepo rectangleRepo;

    private TextField textFieldWidth;
    private TextField textFieldHeight;
    private Button button;


    @Autowired
    public RectangleGUI(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        textFieldWidth = new TextField("Enter height");
        textFieldHeight = new TextField("Enter width");
        button = new Button("Add!");

        button.addClickListener(clickEvent -> addRectangle());

        add(textFieldWidth);
        add(textFieldHeight);
        add(button);
    }

    public void addRectangle(){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(Integer.parseInt(textFieldHeight.getValue()));
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));
        rectangleRepo.save(rectangle);
        Notification notification = new Notification(
                "Rectangle added!", 3000);
        notification.open();
    }
}
