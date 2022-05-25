package tech.hoody.blog.backend.domain;

import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Blog options
 * @author hoody
 * @since 2022/5/25
 */
@Table(appliesTo = "options", comment = "Blog options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "auto")
    private Long id;

    /**
     * option_name to use
     */
    @Column(name="option_name",length = 20,nullable = false,unique = true)
    private String optionName;


    /**
     * option_value to use
     */
    @Column(name="option_value",nullable = false,columnDefinition = "longtext")
    private String optionValue;

    /**
     * option_description to use
     */
    @Column(name="option_description",length = 50,nullable = true)
    private String optionDescription;


    /**
     * dose Option autoload to memory at server startup
     */
    @Column(name = "autoload",nullable = false)
    private boolean autoload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    public boolean isAutoload() {
        return autoload;
    }

    public void setAutoload(boolean autoload) {
        this.autoload = autoload;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", optionName='" + optionName + '\'' +
                ", optionValue='" + optionValue + '\'' +
                ", optionDescription='" + optionDescription + '\'' +
                ", autoload=" + autoload +
                '}';
    }
}
