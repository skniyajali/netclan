package com.niyaj.model

data class PersonalProfile(
    val userId: String,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val age: String,
    val profession: String,
    val userAvailability: UserAvailability,
    val userPurpose: Set<UserPurpose>,
    val hyperLocalDistance: Float = 0.5f,
    val userStatus: String,
    val locationRange: String, // TODO: should be calculated using real time location
    val profileCompletionStatus: Float, // TODO: should be calculated based on user profile information
    val profileImage: String = "",
    val summary: String = "",
    val personalEmail: String = "",
    val officeEmail: String = "",
    val personalPhone: String = "",
    val officePhone: String = "",
    val website: String = "",
    val address: String = "",
    val city: String = "",
    val foodInfo: Set<String> = emptySet(),
    val hobbiesInfo: Set<String> = emptySet(),
    val moviesInfo: Set<String> = emptySet(),
    val sportsInfo: Set<String> = emptySet(),
)

sealed class UserAvailability(val title: String, val status: String) {
    data object SOS : UserAvailability("SOS", "SOS | Emergency! Need Assistance! HELP")
    data object Available : UserAvailability("Available", "Available | Hey Let Us Connect")
    data object Away : UserAvailability("Away", "Away | Stay Discrete And Watch")
    data object Busy : UserAvailability("Busy", "Busy | Do Not Disturb | Will Catch Up Later")
}

val userAvailability = listOf(
    UserAvailability.SOS,
    UserAvailability.Available,
    UserAvailability.Away,
    UserAvailability.Busy
)

val userPurposes = UserPurpose.entries.toList()

enum class UserPurpose {
    Coffee,
    Business,
    Hobbies,
    Friendship,
    Movies,
    Dining,
    Dating,
    Matrimony
}


fun List<PersonalProfile>.filterProfile(searchText: String): List<PersonalProfile> {
    return if (searchText.isNotEmpty()) {
        this.filter { profile ->
            profile.age.contains(searchText, true) ||
                    profile.address.contains(searchText, true) ||
                    profile.city.contains(searchText, true) ||
                    profile.firstName.contains(searchText, true) ||
                    profile.lastName.contains(searchText, true) ||
                    profile.profession.contains(searchText, true) ||
                    profile.gender.name.contains(searchText, true)
        }
    }else this
}