package my.example

case class Car(model: String, owner: Option[Driver], registrationPlate: Option[String]) {
    def ownerDrivingLicense(ownerName: String): Option[String] = {
        // owner.flatMap(_.drivingLicense).map(_.toUpperCase).
        owner.flatMap { owner =>
            if (owner.name == ownerName) owner.drivingLicense.map(_.toUpperCase)
            else None
        }
        // for {
        //     person <- owner
        //     if person.nmae == ownerName
        //     license <- person.drivingLicense
        // } yield license.toUppercase
    }

    def licensedOwner(): Option[Car] =
        Some(this).find { car =>
            car.owner.flatMap {owner =>
                owner.drivingLicense
            }.isDefined
        }

    def ownerBelowAge(age: Int): Option[String] =
        // owner.flatMap { owner =>
        //     if (owner.age < age) Some(owner.name)
        //     else None
        // }
        for {
            owner <- this.owner
            if owner.age < age
        } yield owner.name

    def ownerDrivingLicenseV2(): Option[String] = {
        for {
            person <- owner
            drivingLicense <- person.drivingLicense
        } yield drivingLicense
    }
}

case class Driver(name: String, age: Int, drivingLicense: Option[String])