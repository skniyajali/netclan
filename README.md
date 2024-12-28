
# Netclan: Multi-Module Job Search, and Matrimony Application

A comprehensive, multi-module Android application built with **Kotlin**, **Jetpack Compose**, and **Material 2 Design**, offering a variety of features, including **matchmaking & dating**, **buy/sell/rent**, **job search**, and **matrimony** functionalities. This app provides users with an intuitive and seamless experience across diverse domains.

## Features

### 1. **Matchmaking & Dating**
- Create user profiles and connect with potential matches.
- Advanced search filters (age, location, interests, etc.).
- In-app chat for communication.
- Profile privacy and security options.

### 2. **Buy, Sell, and Rent**
- Marketplace for users to list, buy, sell, or rent items.
- Product listings with detailed descriptions, photos, and user ratings.
- Secure in-app payments for transactions.
- Real-time notifications for new messages and updates.

### 3. **Job Search**
- Search for job opportunities based on skills, experience, and preferences.
- Employers can post job listings and review candidate applications.
- Real-time notifications for job alerts and new opportunities.

### 4. **Matrimony**
- Detailed user profiles for matrimonial purposes.
- Preference-based matching to connect suitable candidates.
- Profile sharing with potential matches for marriage.

## Technologies Used

- **Kotlin**: Primary programming language for Android development.
- **Jetpack Compose**: Declarative UI framework for building modern, responsive user interfaces.
- **Material 2 Design**: Design system for building visually consistent and user-friendly UIs.
- **Retrofit**: For efficient API communication to fetch and submit data.
- **Firebase**: For authentication, real-time notifications, and secure data management.
- **Room**: Local database for offline data storage.
- **Glide**: For image loading and caching.
- **Dagger Hilt**: Dependency Injection for clean and modular architecture.
- **GitHub Actions & Fastlane**: For CI/CD pipeline automation.

## Architecture

The app follows a **multi-module architecture**, allowing each feature to function independently while maintaining a shared codebase for common functionality. The app is structured as follows:

- **Matchmaking & Dating Module**
- **Buy/Sell/Rent Module**
- **Job Search Module**
- **Matrimony Module**
- **Core Module** (Shared components like network, database, utilities)

This modular architecture enhances maintainability, scalability, and testing. Each module can be developed, tested, and deployed independently, reducing the complexity of the overall system.

## Installation

### Prerequisites
- **Android Studio**: Ensure you have the latest version of [Android Studio](https://developer.android.com/studio) installed.
- **Android SDK**: Required for building the project.

### Clone the Repository
To get started with the project, clone the repository to your local machine:
```bash
git clone https://github.com/skniyajali/netclan.git
```

### Setup
1. Open Android Studio.
2. Select "Open an Existing Project" and navigate to the project directory.
3. Sync the project with Gradle files.
4. Build the project.

## Running the Application

1. Connect an Android device or start an emulator.
2. Run the app from Android Studio using the green **Run** button.

The app will launch, and you can explore its features for matchmaking, buying/selling, job searching, and matrimonial purposes.

## CI/CD

The project is integrated with **GitHub Actions** for continuous integration for automating the build and deployment processes. The CI/CD pipeline ensures efficient testing, building, and deploying of new versions of the app. Upon each commit, the pipeline runs tests and validates the build before pushing it to the app store.

## Contributing

We welcome contributions from the community! Here’s how you can get involved:
1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request.

---

## Screenshots

|                                                                                                   |                                                                                               |                                                                                                  |
|:-------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------:|-------------------------------------------------------------------------------------------------:|
| ![App Screenshot](https://github.com/skniyajali/netclan/blob/main/docs/assets/explore_screen.jpg) | ![App Screenshot](https://github.com/skniyajali/netclan/blob/main/docs/assets/drawer_bar.jpg) |           ![App Screenshot](https://github.com/skniyajali/netclan/blob/main/docs/assets/fab.jpg) |
|   ![App Screenshot](https://github.com/skniyajali/netclan/blob/main/docs/assets/empty_box.jpg)    | ![App Screenshot](https://github.com/skniyajali/netclan/blob/main/docs/assets/fab_button.jpg) | ![App Screenshot](https://github.com/skniyajali/netclan/blob/main/docs/assets/refine_screen.jpg) |

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

