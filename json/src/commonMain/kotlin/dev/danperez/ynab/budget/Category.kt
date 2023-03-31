package dev.danperez.ynab.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: String,
    @SerialName("category_group_id") val categoryGroupId: String,
    val name: String,
    val hidden: Boolean,
    @SerialName("original_category_group_id") val originalCategoryGroupId: String,
    val note: String,
    val budgeted: Int,
    val activity: Int,
    val balance: Int,
    @SerialName("goal_type") val goalType: String,
    @SerialName("goal_day") val goalDay: Int,
    @SerialName("goal_cadence") val goalCadence: Int,
    @SerialName("goal_cadence_frequency") val goalCadenceFrequency: Int,
    @SerialName("goal_creation_month") val goalCreationMonth: String,
    @SerialName("goal_target") val goalTarget: Int,
    @SerialName("goal_target_month") val goalTargetMonth: String,
    @SerialName("goal_percentage_complete") val goalPercentageComplete: Int,
    @SerialName("goal_months_to_budget") val goalMonthsToBudget: Int,
    @SerialName("goal_under_funded") val goalUnderFunded: Int,
    @SerialName("goal_overall_funded") val goalOverallFunded: Int,
    @SerialName("goal_overall_left") val goalOverallLeft: Int,
    val deleted: Boolean
)