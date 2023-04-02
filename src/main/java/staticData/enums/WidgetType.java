package staticData.enums;

public enum WidgetType {

    ACCORDION("accordion"),
    AUTOCOMPLETE("autocomplete"),
    BUTTON("button");

    final String value;
    WidgetType(String value){
        this.value= value;
    }

    public String getValue() {
        return value;
    }

}
