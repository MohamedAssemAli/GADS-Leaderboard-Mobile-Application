package com.assem.gadsleaderboard.utils

import android.util.Patterns
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout


/**
 * Created by Mohamed Assem on 29-Aug-2020.
 * mohamed.assem.ali@gmail.com
 * https://github.com/MohamedAssemAli
 */
class Validation {
    companion object {
        private fun isEmptyEditText(editText: EditText): Boolean {
            return editText.text.isNullOrEmpty()
        }

        fun isValidEmail(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidUserName(username: String): Boolean {
            return username.length >= 2
        }

        fun isValidPassword(password: String): Boolean {
            return password.length >= 6
        }

        fun validateInput(
            textInputLayout: TextInputLayout,
            emptyInputErrorMsg: String,
            invalidInputErrorMsg: String,
            inputPatternValidation: Boolean
        ): Boolean {
            return if (isEmptyEditText(textInputLayout.editText!!)) {
                textInputLayout.error = emptyInputErrorMsg
                false
            } else {
                if (inputPatternValidation) {
                    textInputLayout.isErrorEnabled = false
                    true
                } else {
                    textInputLayout.error = invalidInputErrorMsg
                    false
                }
            }
        }
    }
}