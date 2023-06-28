package com.pd.domain.usecase

import com.pd.common.usecase.NoInputSuspendingUseCase
import com.pd.domain.entity.FeedList

interface FeedUseCase: NoInputSuspendingUseCase<Result<FeedList>>