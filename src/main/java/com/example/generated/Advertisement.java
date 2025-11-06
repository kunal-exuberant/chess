public class Advertisement {
    private String title;
    private String description;
    private int impressions;
    private int clicks;
    private int conversions;

    public Advertisement(String title, String description) {
        this.title = title;
        this.description = description;
        this.impressions = 0;
        this.clicks = 0;
        this.conversions = 0;
    }

    public void recordImpression() {
        impressions++;
    }

    public void recordClick() {
        clicks++;
    }

    public void recordConversion() {
        conversions++;
    }

    public double getCTR() {
        return impressions > 0 ? (double) clicks / impressions * 100 : 0.0;
    }

    public double getCVR() {
        return clicks > 0 ? (double) conversions / clicks * 100 : 0.0;
    }

    // Getters for testing purposes
    public int getImpressions() {
        return impressions;
    }

    public int getClicks() {
        return clicks;
    }

    public int getConversions() {
        return conversions;
    }
}