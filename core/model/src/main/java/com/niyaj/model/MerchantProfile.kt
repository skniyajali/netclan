package com.niyaj.model

data class MerchantProfile(
    val merchantId: String,
    val merchantName: String,
    val companyName: String,
    val category: String,
    val yearOfEst: Int,
    val address: String,
    val city: String,
    val locationRange: String,
    val outletImage: String = "", // TODO: mark as necessary
    val profileStatus: Float, // TODO: should be calculated using profile information
    val merchantStatus: String,
    val email: String = "",
    val phone: String = "",
    val website: String = "",
    val description: String = "",
)


fun List<MerchantProfile>.searchProfiles(searchText: String): List<MerchantProfile> {
    return if (searchText.isNotEmpty()) {
        this.filter { profile ->
            profile.merchantName.contains(searchText, true) ||
                    profile.category.contains(searchText, true) ||
                    profile.companyName.contains(searchText, true) ||
                    profile.city.contains(searchText, true) ||
                    profile.address.contains(searchText, true) ||
                    profile.website.contains(searchText, true) ||
                    profile.description.contains(searchText, true) ||
                    profile.email.contains(searchText, true) ||
                    profile.phone.contains(searchText, true)
        }
    }else this
}