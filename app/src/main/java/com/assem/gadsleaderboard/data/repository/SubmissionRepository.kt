package com.assem.gadsleaderboard.data.repository

import com.assem.gadsleaderboard.data.api.ServiceBuilder


/**
 * Created by Mohamed Assem on 08-Sep-20.
 * mohamed.assem.ali@gmail.com
 */

class SubmissionRepository {
    suspend fun submitProject(
        url: String,
        email: String,
        firstName: String,
        lastName: String,
        projectLink: String
    ) = ServiceBuilder.api.submitProject(
        url,
        email,
        firstName,
        lastName,
        projectLink
    )
}