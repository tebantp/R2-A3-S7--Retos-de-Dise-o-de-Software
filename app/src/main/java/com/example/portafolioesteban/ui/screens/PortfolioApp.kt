package com.example.portafolioesteban.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.portafolioesteban.viewmodel.ProfileViewModel
import kotlinx.coroutines.launch

@Composable
fun PortfolioApp(viewModel: ProfileViewModel) {
    val vPagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()

    VerticalPager(
        state = vPagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        when (page) {
            0 -> Screen1(
                viewModel = viewModel,
                onScrollDown = {
                    scope.launch { vPagerState.animateScrollToPage(1) }
                }
            )
            1 -> Screen2(
                viewModel = viewModel,
                onScrollUp = {
                    scope.launch { vPagerState.animateScrollToPage(0) }
                },
                onScrollDown = {
                    scope.launch { vPagerState.animateScrollToPage(2) }
                }
            )
            2 -> Screen3And4(
                viewModel = viewModel,
                onScrollUp = {
                    scope.launch { vPagerState.animateScrollToPage(1) }
                },
                onGoToStart = {
                    scope.launch { vPagerState.animateScrollToPage(0) }
                }
            )
        }
    }
}