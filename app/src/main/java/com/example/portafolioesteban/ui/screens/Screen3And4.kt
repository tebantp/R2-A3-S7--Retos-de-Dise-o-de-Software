package com.example.portafolioesteban.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.portafolioesteban.viewmodel.ProfileViewModel
import kotlinx.coroutines.launch

@Composable
fun Screen3And4(
    viewModel: ProfileViewModel,
    onScrollUp: () -> Unit,
    onGoToStart: () -> Unit
) {
    val hPagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()

    HorizontalPager(
        state = hPagerState,
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = true
    ) { page ->
        when (page) {
            0 -> Screen3(
                viewModel = viewModel,
                onScrollUp = onScrollUp,
                onShowMore = {
                    scope.launch { hPagerState.animateScrollToPage(1) }
                }
            )
            1 -> Screen4(
                viewModel = viewModel,
                onBack = {
                    scope.launch { hPagerState.animateScrollToPage(0) }
                },
                onGoToStart = onGoToStart
            )
        }
    }
}
