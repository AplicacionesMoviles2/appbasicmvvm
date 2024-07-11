package pe.idat.appbasicmvvm.routes

sealed class AppRoutes(val path: String) {
    object loginScreen: AppRoutes("loginScreen")
    object homeScreen: AppRoutes("homeScreen")
}