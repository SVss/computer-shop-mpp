package by.bsuir.mpp.computershop.dto.brief;

public class ComponentTypeBriefDto extends BaseBriefDto {

    private String name;

    private String description;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}