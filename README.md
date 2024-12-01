
# Gouzour 

A simple+lightweight template for a Jetpack Compose app with Navigation, Retrofit, Dagger-Hilt fully setup for convenience, so you can **focus only on what's important!**

> ***"Every line of code should be written once, and only once." - Ron Jeffries***


## Features 🎨

- Project fully in `Jetpack Compose`
- Jetpack Compose Navigation
- Retrofit *(Fully setup with a working api call)*
- MVVM Architecture
- Kotlin Domain-Specific-Language
- [Chucker](https://github.com/ChuckerTeam/chucker)
- Dependency versions managed `Gradle Version Catalog`
- `Dependabot` *(with a weekly schedule)*
- `GitHub Actions` for building apk and uploading artifact
- Glide *(for image loading)*

## Project Structure 🗺️📐🛠️

The project includes a single module **`app`**, with following packages:

- **`di`:** contains Dagger-Hilt Module
- **`network`:** includes api service containing api endpoints & type of request
- **`model`:** contains response data class from the server
- **`repository`:** contains repository interface & its implementation
- **`presentation`:** signifies the presentation layer

## Contributing 🤝

Join us in shaping the future of this project – your contributions are invaluable! Feel free to open a issue or submit a pull request for any bugs/improvements.

## License

Distributed under the MIT License. See `LICENSE` file for more information.