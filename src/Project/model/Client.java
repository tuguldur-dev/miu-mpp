package Project.model;

public class Client {
    private int clientId;
    private String name;
    private String industry;
    private String contactName;
    private String contactPhone;
    private String contactEmail;

    public Client() {}

    public Client(int clientId, String name, String industry, String contactName, String contactPhone, String contactEmail) {
        this.clientId = clientId;
        this.name = name;
        this.industry = industry;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
    }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    @Override
    public String toString() {
        return "Client{id=" + clientId + ", name='" + name + "', industry='" + industry + "', contact='" + contactName + "'}";
    }
}
