package cl.biblioteca.bibliotecaejercicio.dto;

public class PokemonResponse {
    private Long id;
    private String name;
 
 
    private Boolean is_legendary;
    private String base_happiness;
    private String capture_rate;
 
 
    public Long getId() {
        return id;
    }
 
 
    public void setId(Long id) {
        this.id = id;
    }
 
 
    public String getName() {
        return name;
    }
 
 
    public void setName(String name) {
        this.name = name;
    }
 
 
    public Boolean getIs_legendary() {
        return is_legendary;
    }
 
 
    public void setIs_legendary(Boolean isLegendary) {
        this.is_legendary = isLegendary;
    }

    public String getbase_happiness() {
         return this.base_happiness;
    }
    public void setbase_happiness(String base_happiness) {
        this.base_happiness= base_happiness;
    }

    public String getcapture_rate() {
         return this.capture_rate;
    }
    public void setcapture_rate(String capture_rate) {
        this.capture_rate= capture_rate;
    }
}


