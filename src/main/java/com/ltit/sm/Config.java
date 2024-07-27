package com.ltit.sm;

public class Config {
    public Links links = new Links();
    public ServerData serverData = new ServerData();

    public static class Links {
        public String discord = "none";
        public String youtube = "none";
        public String website = "none";
        public String tiktok = "none";
        public String insta = "none";
        public String x = "none";
        public String threads = "none";
        public String store = "none";
    }
    public static class ServerData {
        public String name = "unknown";
        public String description = "unknown";
        public String type = "unknown";
    }
}
