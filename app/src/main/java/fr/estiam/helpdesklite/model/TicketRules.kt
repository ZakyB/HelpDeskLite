package fr.estiam.helpdesklite.model

object TicketRules {
    private val allowedTransitions = setOf(
        Status.OPEN to Status.IN_PROGRESS,
        Status.IN_PROGRESS to Status.RESOLVED,
    )

    private val priorityRank = mapOf(
        Priority.HIGH to 0,
        Priority.MEDIUM to 1,
        Priority.LOW to 2,
    )

    fun canTransition(from: Status, to: Status): Boolean = (from to to) in allowedTransitions

    // sortedBy is stable and returns a new list, so ties keep their order and the input is untouched.
    fun sortByPriority(tickets: List<SupportTicket>): List<SupportTicket> =
        tickets.sortedBy { priorityRank.getValue(it.priority) }
}
