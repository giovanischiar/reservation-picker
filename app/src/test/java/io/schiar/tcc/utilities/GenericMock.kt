package io.schiar.tcc.utilities

import org.mockito.AdditionalAnswers.delegatesTo
import org.mockito.Mockito

class GenericMock {
    companion object {
        inline fun <reified T> any(): T {
            return Mockito.any(T::class.java)
        }

        inline fun <reified T> mock(): T {
            return Mockito.mock(T::class.java)
        }

        inline fun <reified T> spyLambda(lambda: T): T {
            return Mockito.mock(T::class.java, delegatesTo<Any>(lambda))
        }
    }
}