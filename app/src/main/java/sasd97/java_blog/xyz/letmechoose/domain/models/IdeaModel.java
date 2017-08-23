package sasd97.java_blog.xyz.letmechoose.domain.models;

/**
 * Created by alexander on 17/07/2017.
 */

public class IdeaModel {

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IdeaModel{");
        sb.append("description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
