package com.example.serenitysoul.screens

import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.serenitysoul.R

@Composable
fun SettingsScreen(
    textId: Int,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: (String) -> Unit,
    onShowAboutScreen: () -> Unit,
    modifier: Modifier = Modifier,
    showState: MutableState<Boolean>,
    //bottomSheetState: SheetState,
    dragHandle: @Composable (() -> Unit),
    content: @Composable ColumnScope.() -> Unit,
    argument: Bundle
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val s = argument.getString("")

    if (showState.value) {
        ModalBottomSheet(
            modifier = Modifier.systemBarsPadding(),
            onDismissRequest = { showState.value = false },
            sheetState = bottomSheetState,
            //scrimColor = VtbTheme.colorScheme.scrim,
            //containerColor = VtbTheme.colorScheme.background,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            tonalElevation = 0.dp,
            dragHandle = dragHandle,
        ) {
            content()
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
        }
    }
    Column {
        //Spacer(modifier = Modifier.size(20.dp))
        Text(text = stringResource(id = textId))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                showState.value = true
            }
        ) {
            Text(stringResource(R.string.show_list))
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {onCancelButtonClicked.invoke("987")}
            ) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                //enabled = selectedValue.isNotEmpty(),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.about_app))
            }
        }
    }
}