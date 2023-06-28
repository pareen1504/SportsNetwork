package com.pd.common.usecase

interface SuspendingUseCase<in Input, out Output> {
    suspend fun execute(input: Input): Output
}