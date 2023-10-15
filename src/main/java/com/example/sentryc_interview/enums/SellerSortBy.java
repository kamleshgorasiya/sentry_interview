package com.example.sentryc_interview.enums;

public enum SellerSortBy {
    SELLER_INFO_EXTERNAL_ID_ASC("externalId_asc"),
    SELLER_INFO_EXTERNAL_ID_DESC("externalId_desc"),
    NAME_ASC("name_asc"),
    NAME_DESC("name_desc"),
    MARKETPLACE_ID_ASC("marketplaceId_asc"),
    MARKETPLACE_ID_DESC("marketplaceId_desc");

    private final String displayName;

    SellerSortBy(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}