public interface DamageClaimRepository extends JpaRepository<DamageClaim, Long> {
    DamageClaim findByParcel_Id(Long parcelId);
}
