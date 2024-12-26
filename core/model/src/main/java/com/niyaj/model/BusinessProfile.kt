package com.niyaj.model

data class BusinessProfile(
    val profileId: String,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val age: String,
    val profession: String,
    val companyName: String,
    val serviceType: String,
    val locationRange: String,
    val yearsOfExperience: Int,
    val address: String,
    val city: String,
    val userStatus: String,
    val userAvailability: BusinessProfileAvailability,
    val hyperLocalDistance: Int = 50,
    val profileStatus: Float, // TODO: should be calculated using profile information
    val profileImage: String = "",
    val email: String = "",
    val phoneNo: String = "",
    val summary: String = "",
)


sealed class BusinessProfileAvailability(val title: String, val status: String) {
    data object Available : BusinessProfileAvailability(
        title = "Available",
        status = "Available | Hey Let Us Connect"
    )

    data object Away : BusinessProfileAvailability(
        title = "Away",
        status = "Away | Stay Discreet And Watch"
    )

    data object Busy : BusinessProfileAvailability(
        title = "Busy",
        status = "Busy | Do Not Disturb | Will Catch Up Later"
    )
}

fun List<BusinessProfile>.searchProfile(searchText: String): List<BusinessProfile> {
    return if (searchText.isNotEmpty()) {
        this.filter { profile ->
            profile.age.contains(searchText, true) ||
                    profile.address.contains(searchText, true) ||
                    profile.city.contains(searchText, true) ||
                    profile.companyName.contains(searchText, true) ||
                    profile.phoneNo.contains(searchText, true) ||
                    profile.firstName.contains(searchText, true) ||
                    profile.lastName.contains(searchText, true) ||
                    profile.serviceType.contains(searchText, true) ||
                    profile.gender.name.contains(searchText, true) ||
                    profile.email.contains(searchText, true)
        }
    } else this
}