data class Medicamentos(
    val nregistro: String,
    val nombre: String?,
    val pactivos: String?,
    val labtitular: String?,
    val estado: Estado?,  // Cambio aquí: `estado` ya no es un String
    val comercializado: Boolean?
)

data class Estado(
    val aut: String?,  // Fecha de autorización
    val susp: String?, // Fecha de suspensión
    val rev: String?   // Fecha de revocación
)
