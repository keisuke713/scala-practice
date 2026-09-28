package org.example.movies

import PrintResultHelpers._

object MovieApp extends App {
    val dataset = new MoviesDataset("movies_metadata.csv")
    val movies = dataset.movies

    private val unknown = "--"

    printResult(
        question = "How many movies are there in the dataset?",
        answer = {
            val totalCount = movies.size
            s"$totalCount movies"
        }
    )

    printResult(
        question = "How many movies were released in 1987?",
        answer = {
            val countFrom1987 = movies.count(_.releaseDate.exists(_.getYear == 1987))
            s"$countFrom1987 movies"
        }
    )

    printResult(
        question = "TOP 5 moviews per vote average and count",
        answers = {
            val totalPerVote =
                movies.filter(_.voteCount > 50).sortBy( m => (- m.voteAverage, m.voteCount)).take(5)
            totalPerVote.map {m =>
                s"[AVG: ${m.voteAverage}, COUNT: ${m.voteCount}] ${m.title}"
            }
        }
    )

    printResult(
        question = "TOP 5 movies per popularity",
        answers = {
            val topPerPopularity =
                movies.sortBy { m =>
                    -m.popularity.getOrElse(0f)
                }.take(5)
            topPerPopularity.map { m =>
                s"[POPULARITY: ${m.popularity.getOrElse(unknown)}] ${m.title}"
            }
        }
    )

    printResult(
        question = "5 non-English moviews",
        answers = {
            val topNonEnglishPerPopularity =
                movies.filterNot(_.originalLanguage == "en").sortBy { m =>
                    -m.popularity.getOrElse(0f)
                }.take(5)
            topNonEnglishPerPopularity.map { m =>
                s"[LANG: ${m.originalLanguage}], [POPULARITY: ${m.popularity.getOrElse(unknown)}] ${m.title}"
            }
        }
    )

    printResult(
        question = "5 japanese moviews",
        answers = {
            val topNonEnglishPerPopularity =
                movies.filter(_.originalLanguage == "ja").sortBy { m =>
                    -m.popularity.getOrElse(0f)
                }.take(5)
            topNonEnglishPerPopularity.map { m =>
                s"[LANG: ${m.originalLanguage}], [POPULARITY: ${m.popularity.getOrElse(unknown)}] ${m.title}"
            }
        }
    )

    printResult(
        question = "which movie made the most profit",
        answer = {
            val mostProfit =
                movies.maxBy { m =>
                    m.revenue - m.budget
                }
            val formattedProfit = {
                val formatter = java.text.NumberFormat.getInstance()
                formatter.format(mostProfit.revenue - mostProfit.budget)
            }
            s"[PROFIT: USD $formattedProfit] ${mostProfit.title}"
        }
    )
}