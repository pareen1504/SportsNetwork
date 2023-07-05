package com.pd.domain.usecase

import com.pd.common.usecase.SuspendingUseCase

interface DateUseCase: SuspendingUseCase<String, Pair<String, Long>?>