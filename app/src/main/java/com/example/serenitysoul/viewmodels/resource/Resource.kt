package com.example.serenitysoul.viewmodels.resource

sealed class Resource<out T> {

    object Loading : Resource<Nothing>()

    data class Success<out T>(
        val value: T
    ) : Resource<T>()

    data class Fail<out T>(
        val error: Throwable? = null,
        val valueError: T? = null
    ) : Resource<T>()

    val isLoading get() = this is Loading
    val isFail get() = this is Fail
    val valueOrNull get() = (this as? Success)?.value

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[value = $value]"
            is Fail -> "Error[exception = $error]"
            Loading -> "Loading"
        }
    }
}

/**
 * `true` если [Resource] вернул [Success] и значение не пустое [Success.value].
 */
val Resource<*>.succeeded
    get() = this is Resource.Success && value != null

fun <T> Resource<T>.successOr(fallback: T): T {
    return (this as? Resource.Success<T>)?.value ?: fallback
}

val <T> Resource<T>.value: T?
    get() = (this as? Resource.Success)?.value