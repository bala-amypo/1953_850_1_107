public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    boolean existsByTrackingNumber(String trackingNumber);
    Parcel findByTrackingNumber(String trackingNumber);
}
