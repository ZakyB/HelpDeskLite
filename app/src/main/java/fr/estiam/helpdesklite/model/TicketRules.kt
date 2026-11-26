package fr.estiam.helpdesklite.model

object TicketRules {
    /** Seules transitions autorisées : OPEN → IN_PROGRESS et IN_PROGRESS → RESOLVED. */
    fun canTransition(from: Status, to: Status): Boolean = when (from) {
        Status.OPEN -> to == Status.IN_PROGRESS
        Status.IN_PROGRESS -> to == Status.RESOLVED
        Status.RESOLVED -> false
    }

    /**
     * Trie HIGH, MEDIUM puis LOW. sortedBy est un tri stable : les tickets de même
     * priorité gardent leur ordre d'origine. Renvoie une nouvelle liste, l'entrée n'est pas modifiée.
     */
    fun sortByPriority(tickets: List<SupportTicket>): List<SupportTicket> =
        tickets.sortedBy { priorityRank(it.priority) }

    private fun priorityRank(priority: Priority): Int = when (priority) {
        Priority.HIGH -> 0
        Priority.MEDIUM -> 1
        Priority.LOW -> 2
    }
}
