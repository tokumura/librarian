package com.tokumura.librarian.presentation.form

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("error")
class ErrorResponse(val errorMessage: String)