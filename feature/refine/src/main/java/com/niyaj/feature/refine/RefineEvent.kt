package com.niyaj.feature.refine

import com.niyaj.model.UserAvailability
import com.niyaj.model.UserPurpose

sealed class RefineEvent {

    data class OnSelectUseAvailability(val status: UserAvailability) : RefineEvent()

    data class OnChangeStatus(val status: String) : RefineEvent()

    data class OnChangeHyperDistance(val distance: Float) : RefineEvent()

    data class OnSelectUserPurpose(val purpose: UserPurpose) : RefineEvent()

    data object OnClickSave: RefineEvent()
}