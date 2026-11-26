package fr.estiam.helpdesklite.model

object TicketValidation {
    private const val MIN_DESCRIPTION_LENGTH = 10

    /** Valide si le titre contient au moins un caractère non blanc. */
    fun isTitleValid(title: String): Boolean = title.isNotBlank()

    /** Valide si la description, une fois les espaces de début et de fin retirés, fait au moins 10 caractères. */
    fun isDescriptionValid(description: String): Boolean =
        description.trim().length >= MIN_DESCRIPTION_LENGTH

    fun create(
        id: String,
        title: String,
        description: String,
        priority: Priority,
        createdAt: Long,
    ): SupportTicket? {
        if (!isTitleValid(title) || !isDescriptionValid(description)) return null
        return SupportTicket(
            id = id,
            title = title.trim(),
            description = description.trim(),
            priority = priority,
            status = Status.OPEN,
            createdAt = createdAt,
        )
    }
}
