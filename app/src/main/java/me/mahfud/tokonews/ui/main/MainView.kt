package me.mahfud.tokonews.ui.main

import me.mahfud.tokonews.model.Source

interface MainView {
    fun onSourcesReady(sources: List<Source>)
}