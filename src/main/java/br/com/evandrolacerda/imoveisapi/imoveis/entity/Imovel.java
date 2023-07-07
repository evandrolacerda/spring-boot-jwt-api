package br.com.evandrolacerda.imoveisapi.imoveis.entity;


import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "description" , length = 4000 )
    private String description;

    @Column(name = "address" , length = 1000 )
    private String address;

    @Column( name="price" ,  precision = 10, scale = 2 )
    private BigDecimal price;

    @Column(name = "type" , length = 100 )
    private String type;

    @Column( name="private_area" )
    private float privateArea;

    @Column( name="public_area" )
    private float publicArea;

    @Column( name="advertizer" )
    private String advertizer;

    @Column( name="add_url" )
    private String addUrl;


    @Column( name="number" )
    private String number;

    @Column( name="neighborhood" )
    private String neighborhood;

    @Column( name="city" )
    private String city;

    @Column( name="state" )
    private String state;

    @Column( name="zip_code" )
    private String zipCode;

    @Column( name="site" )
    private String site;

    @Column( name="add_id")
    private String addId;

    @Column(name="add_source")
    private String addSource;

    @Column( name="online")
    private Boolean online;

    @OneToMany(mappedBy = "imovel")
    private List<Image> images;


    public String getAddSource() {
        return addSource;
    }

    public Boolean getOnline() {
        return online;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public String getIdMongo() {
        return idMongo;
    }

    public String getHash() {
        return hash;
    }

    @Column( name="price_m2_public_area" , precision = 10, scale = 2 )
    private BigDecimal priceM2PublicArea;

    @Column( name="price_m2_private_area" , precision = 10, scale = 2 )
    private BigDecimal priceM2PrivateArea;

    @Column( name="bussiness_type" )
    private String bussinessType;

    @Column( name="bedrooms_number", nullable = true )
    private Integer bedroomsNumber;

    @Column( name="bathrooms_number", nullable = true )
    private Integer bathroomsNumber;

    @Column( name="garage_number", nullable = true )
    private Integer garageNumber;

    @Column( name="suites_number", nullable = true )
    private Integer suitesNumber;


    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="location" , columnDefinition = "geometry")
    private Point location;

    @Column( name="title")
    private String title;

    @Column( name="id_mongo")
    private String idMongo;

    @Column( name="hash")
    private String hash;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;





    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrivateArea() {
        return privateArea;
    }

    public void setPrivateArea(float privateArea) {
        this.privateArea = privateArea;
    }

    public float getPublicArea() {
        return publicArea;
    }

    public void setPublicArea(float publicArea) {
        this.publicArea = publicArea;
    }

    public String getAdvertizer() {
        return advertizer;
    }

    public void setAdvertizer(String advertizer) {
        this.advertizer = advertizer;
    }

    public String getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId;
    }

    public BigDecimal getPriceM2PublicArea() {
        return priceM2PublicArea;
    }

    public void setPriceM2PublicArea(BigDecimal priceM2PublicArea) {
        this.priceM2PublicArea = priceM2PublicArea;
    }

    public BigDecimal getPriceM2PrivateArea() {
        return priceM2PrivateArea;
    }

    public void setPriceM2PrivateArea(BigDecimal priceM2PrivateArea) {
        this.priceM2PrivateArea = priceM2PrivateArea;
    }

    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    public Integer getBedroomsNumber() {
        return bedroomsNumber;
    }

    public void setBedroomsNumber(Integer bedroomsNumber) {
        this.bedroomsNumber = bedroomsNumber;
    }

    public Integer getBathroomsNumber() {
        return bathroomsNumber;
    }

    public void setBathroomsNumber(Integer bathroomsNumber) {
        this.bathroomsNumber = bathroomsNumber;
    }

    public Integer getGarageNumber() {
        return garageNumber;
    }

    public void setGarageNumber(Integer garageNumber) {
        this.garageNumber = garageNumber;
    }

    public Integer getSuitesNumber() {
        return suitesNumber;
    }

    public void setSuitesNumber(Integer suitesNumber) {
        this.suitesNumber = suitesNumber;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
