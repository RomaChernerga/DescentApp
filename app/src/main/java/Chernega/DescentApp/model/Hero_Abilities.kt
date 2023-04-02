package Chernega.DescentApp.model

data class Hero_Abilities(
    val name: String, val Abilities: String
)

fun getAbilities() : List<Hero_Abilities> {
    return listOf(
        Hero_Abilities("Lord_Hawthorne", "Each time you perform an attack with a Melee weapon, that attacks gains Reach."),
        Hero_Abilities("Avric_Albright", "Each hero within 3 spaces of you (including yourself) gains (Surge: Recover 1 Heart) on all attack rolls."),
    )
}