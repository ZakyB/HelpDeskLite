package fr.estiam.helpdesklite.model

object TicketRules {
    fun canTransition(from: Status, to: Status): Boolean {
        return (from == Status.OPEN && to == Status.IN_PROGRESS) ||
            (from == Status.IN_PROGRESS && to == Status.RESOLVED)
    }

    fun sortByPriority(tickets: List<SupportTicket>): List<SupportTicket> {
        val priorityRank = mapOf(
            Priority.HIGH to 0,
            Priority.MEDIUM to 1,
            Priority.LOW to 2,
        )

        return tickets.sortedWith(compareBy { priorityRank.getValue(it.priority) })
    }
}
