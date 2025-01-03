package com.niyaj.data.repository

import com.niyaj.model.BusinessProfile
import com.niyaj.model.BusinessProfileAvailability
import com.niyaj.model.Gender
import com.niyaj.model.MerchantProfile
import com.niyaj.model.PersonalProfile
import com.niyaj.model.UserAvailability
import com.niyaj.model.UserPurpose

class LocalData {

    val currentUser: PersonalProfile = PersonalProfile(
        userId = "NNCHIN00038000",
        firstName = "Niyaj",
        lastName = "Ali",
        gender = Gender.Male,
        age = "23",
        profession = "Student",
        userAvailability = UserAvailability.Available,
        userPurpose = setOf(UserPurpose.Hobbies, UserPurpose.Coffee, UserPurpose.Friendship),
        hyperLocalDistance = 0.5f,
        userStatus = "Hi, community! I am open to new connections",
        locationRange = "3.2 KM",
        profileCompletionStatus = 0.6f,
        personalEmail = "niyaj@gmail.com",
        personalPhone = "9078563421",
        website = "https://skniyajali.me/",
        address = "Salem, Tamil Nadu, India",
        city = "Salem",
    )

    val personalProfiles = listOf(
        PersonalProfile(
            userId = "NNCHIN00039000",
            firstName = "Surya Prakash",
            lastName = "A",
            gender = Gender.Male,
            age = "22",
            locationRange = "2.4 KM",
            profileCompletionStatus = 0.4f,
            profileImage = "",
            userStatus = "Hi, community! I am open to new connections",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            userAvailability = UserAvailability.Available,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Dating, UserPurpose.Hobbies)
        ),
        PersonalProfile(
            userId = "NNCHIN00040000",
            firstName = "Mohanavel",
            lastName = "K",
            gender = Gender.Female,
            age = "21",
            locationRange = "2.8 KM",
            profileCompletionStatus = 0.5f,
            profileImage = "",
            userStatus = "Hello :)",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            userAvailability = UserAvailability.Available,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Dating, UserPurpose.Dining)
        ),
        PersonalProfile(
            userId = "NNCHIN00041000",
            firstName = "Pradeep Kumar",
            lastName = "M",
            gender = Gender.Male,
            age = "22",
            locationRange = "4.4 KM",
            profileCompletionStatus = 0.3f,
            profileImage = "",
            userStatus = "Hi, community! I am open to new connections",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            userAvailability = UserAvailability.Away,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Movies, UserPurpose.Friendship)
        ),
        PersonalProfile(
            userId = "NNCHIN00042000",
            firstName = "Aishwarya Ramesh",
            lastName = "Babu",
            gender = Gender.Female,
            age = "22",
            locationRange = "4.5 KM",
            profileCompletionStatus = 0.9f,
            profileImage = "",
            userStatus = "Hi, community! I am open to new connections",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            userAvailability = UserAvailability.Available,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Friendship, UserPurpose.Hobbies)
        ),
        PersonalProfile(
            userId = "NNCHIN00043000",
            firstName = "Akilan",
            lastName = "Y",
            gender = Gender.Male,
            age = "23",
            locationRange = "8.2 KM",
            profileCompletionStatus = 0.7f,
            profileImage = "",
            userStatus = "Hi, community! I am open to new connections",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            userAvailability = UserAvailability.Available,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Dining, UserPurpose.Hobbies)
        ),
        PersonalProfile(
            userId = "NNCHIN00044000",
            firstName = "Thoufiq",
            lastName = "Khan",
            gender = Gender.Male,
            age = "23",
            locationRange = "10.2 KM",
            profileCompletionStatus = 0.3f,
            profileImage = "",
            userStatus = "Hi, community! I am open to new connections",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            userAvailability = UserAvailability.Available,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Dating, UserPurpose.Hobbies)
        ),
        PersonalProfile(
            userId = "NNCHIN00045000",
            firstName = "Satish",
            lastName = "M",
            gender = Gender.Male,
            age = "24",
            locationRange = "12.3 KM",
            profileCompletionStatus = 0.4f,
            profileImage = "",
            userStatus = "Hi, community! I am open to new connections",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            foodInfo = setOf("Coffee"),
            userAvailability = UserAvailability.Available,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Friendship, UserPurpose.Movies)
        ),
        PersonalProfile(
            userId = "NNCHIN00046000",
            firstName = "Sowmiya",
            lastName = "Muruganandam",
            gender = Gender.Female,
            age = "23",
            locationRange = "12.4 KM",
            profileCompletionStatus = 0.5f,
            profileImage = "",
            userStatus = "Hi, community! I am open to new connections",
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profession = "Student",
            userAvailability = UserAvailability.Available,
            userPurpose = setOf(UserPurpose.Coffee, UserPurpose.Dating, UserPurpose.Matrimony)
        )
    )

    val businessProfiles = listOf(
        BusinessProfile(
            profileId = "NNCHIN00056000",
            firstName = "Naveen",
            lastName = "Kumar",
            gender = Gender.Male,
            age = "24",
            locationRange = "500-800 m",
            profession = "Software Tester",
            companyName = "Inmakes Learning Hub",
            serviceType = "Technology",
            yearsOfExperience = 0,
            address = "Rasipuram, Tamil Nadu, India",
            city = "Rasipuram",
            profileImage = "",
            email = "naveen129@gmail.com",
            userStatus = "Hi, community I am available to your service",
            userAvailability = BusinessProfileAvailability.Available,
            profileStatus = 0.3f,
            summary = "I have knowledge in selenium web driver using cucumber, Junit ad testing framework also I did my intern Inmakes Learning Hub based on automation testing"
        ),
        BusinessProfile(
            profileId = "NNCHIN00057000",
            firstName = "Praveena",
            lastName = "Manikandan",
            gender = Gender.Female,
            age = "25",
            locationRange = "2 KM",
            profession = "Home Help",
            companyName = "Nil",
            serviceType = "Home Service",
            yearsOfExperience = 2,
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profileImage = "",
            email = "manikandan34@gmail.com",
            userStatus = "Hi, community I am available to your service",
            userAvailability = BusinessProfileAvailability.Available,
            profileStatus = 0.4f
        ),
        BusinessProfile(
            profileId = "NNCHIN00058000",
            firstName = "Porkodi",
            lastName = "Prabhakaran",
            gender = Gender.Male,
            age = "35",
            locationRange = "4 KM",
            profession = "Data Analyst",
            companyName = "Vctw And White Devil",
            serviceType = "Technology",
            yearsOfExperience = 12,
            address = "Namakkal, Tamil Nadu, India",
            city = "Namakkal",
            profileImage = "",
            email = "porkodi45@gmail.com",
            summary = "I worked as a data analyst at White Devil Software Solution",
            userStatus = "Hi, community I am available to your service",
            userAvailability = BusinessProfileAvailability.Busy,
            profileStatus = 0.6f
        ),
        BusinessProfile(
            profileId = "NNCHIN00059000",
            firstName = "Arun",
            lastName = "Kumar",
            gender = Gender.Male,
            age = "25",
            locationRange = "5 KM",
            profession = "Software Engineer",
            companyName = "Wipro",
            serviceType = "Technology",
            yearsOfExperience = 3,
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profileImage = "",
            email = "kumar67@gmail.com",
            summary = "I worked as a software engineer at Wipro",
            userStatus = "Hi, community I am available to your service",
            userAvailability = BusinessProfileAvailability.Available,
            profileStatus = 0.9f
        ),
        BusinessProfile(
            profileId = "NNCHIN00060000",
            firstName = "Sonthosh",
            lastName = "K",
            gender = Gender.Male,
            age = "24",
            locationRange = "9 KM",
            profession = "Software Engineer",
            companyName = "Zoho",
            serviceType = "Technology",
            yearsOfExperience = 3,
            address = "Salem, Tamil Nadu, India",
            city = "Salem",
            profileImage = "",
            email = "sonthosh90@gmail.com",
            summary = "I worked as a software engineer at ZOHO",
            userStatus = "Hi, community I am available to your service",
            userAvailability = BusinessProfileAvailability.Available,
            profileStatus = 0.7f
        )
    )

    val merchantProfiles = listOf(
        MerchantProfile(
            merchantId = "NNCHIN00061000",
            merchantName = "Le Meridien Hydrabad",
            companyName = "Le Meridien Hydrabad",
            category = "Restaurant",
            locationRange = "100 m",
            yearOfEst = 2019,
            address = "Hyderabad, Telengana, India",
            city = "Hyderabad",
            merchantStatus = "Hi, community! We have great deals for you. Check us out!!",
            profileStatus = 0.4f
        ),
        MerchantProfile(
            merchantId = "NNCHIN00062000",
            merchantName = "Royal Orchid Central",
            companyName = "Royal Orchid Central",
            category = "Restaurant",
            yearOfEst = 2019,
            locationRange = "300 m",
            address = "Pune, India",
            city = "Pune",
            outletImage = "",
            email = "",
            website = "",
            merchantStatus = "Hi, community! We have great deals for you. Check us out!!",
            profileStatus = 0.3f
        ),
        MerchantProfile(
            merchantId = "NNCHIN00063000",
            merchantName = "Viventa Goa, Miramar",
            companyName = "Viventa Goa",
            category = "Hotel",
            yearOfEst = 2019,
            locationRange = "4.5 KM",
            address = "Panaji, Goa, India",
            city = "Panaji",
            outletImage = "",
            email = "",
            website = "",
            merchantStatus = "Hi, community! We have great deals for you. Check us out!!",
            profileStatus = 0.7f
        ),
        MerchantProfile(
            merchantId = "NNCHIN00064000",
            merchantName = "Hotel Aristocrat, Darjeeling",
            companyName = "Hotel Aristocrat",
            category = "Hotel",
            yearOfEst = 2017,
            locationRange = "6.5 KM",
            address = "Darjeeling, West Bengal, India",
            city = "Darjeeling",
            outletImage = "",
            email = "",
            website = "",
            merchantStatus = "Hi, community! We have great deals for you. Check us out!!",
            profileStatus = 0.4f
        ),
        MerchantProfile(
            merchantId = "NNCHIN00065000",
            merchantName = "Bake Away Bakery",
            companyName = "Bake Away Bakery",
            category = "Bakery",
            locationRange = "3.5 KM",
            yearOfEst = 2020,
            address = "Indore, Madhya Pradesh, India",
            city = "Indore",
            outletImage = "",
            email = "",
            website = "",
            merchantStatus = "Hi, community! We have great deals for you. Check us out!!",
            profileStatus = 0.8f
        )
    )

}