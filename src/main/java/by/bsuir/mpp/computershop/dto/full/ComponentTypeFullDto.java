package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class ComponentTypeFullDto extends BaseFullDto {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    private String name;

    private String description;

    private Boolean removed;

    private List<ComponentModelBriefDto> models;

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

    public Boolean isRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public List<ComponentModelBriefDto> getModels() {
        return models;
    }

    public void setModels(List<ComponentModelBriefDto> models) {
        this.models = models;
    }
}
