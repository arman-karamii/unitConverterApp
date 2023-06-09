package com.example.firstapp.compose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstapp.ConverterViewModel
import com.example.firstapp.ConverterViewModelFactory
import com.example.firstapp.compose.converter.TopScreen
import com.example.firstapp.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val list = converterViewModel.getConvertions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())
    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list) { message1, message2 ->
            converterViewModel.addResult(message1, message2)
        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(
            historyList, { item ->
                converterViewModel.removeResult(item)
            },
            {
                converterViewModel.clearAll()
            }
        )
    }
}