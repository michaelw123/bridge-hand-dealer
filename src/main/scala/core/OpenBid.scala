package core

object OpenBid {
  val TwoNotrumpsOpen = PointsGreaterAndEqThanPredicate(20) and
    PointsLessThanAndEqualPredicate(21) and
    NTShaped

  val OneHeartOpen = PointsGreaterAndEqThanPredicate(12) and
    PointsLessThanAndEqualPredicate(18) and
    HeartGreaterThanAndEqualPredicate(5)

  val OneSpadeOpen = PointsGreaterAndEqThanPredicate(12) and
    PointsLessThanAndEqualPredicate(18) and
    SpadeGreaterThanAndEqualPredicate(5)

  val TwoClubsOpen = PointsGreaterAndEqThanPredicate(22)

  val OneNoTrumpOpen = PointsGreaterAndEqThanPredicate(15) and
    PointsLessThanAndEqualPredicate(17) and
    NTShaped

  val OneMajorOpen = OneHeartOpen or OneSpadeOpen

  val NTShaped = SuitsLessThanAndEqualPredicate(6) and
    SuitsGreaterThanAndEqualPredicate(2)


}