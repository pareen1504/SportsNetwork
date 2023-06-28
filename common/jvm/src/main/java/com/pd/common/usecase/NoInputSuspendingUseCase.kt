package com.pd.common.usecase

interface NoInputSuspendingUseCase<out Output> {
    suspend fun execute(): Output
}